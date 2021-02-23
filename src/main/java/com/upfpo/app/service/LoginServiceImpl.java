package com.upfpo.app.service;

import java.math.BigInteger;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.upfpo.app.configuration.exception.NotFoundException;
import com.upfpo.app.configuration.exception.response.ExceptionResponse;
import com.upfpo.app.custom.CustomException;
import com.upfpo.app.entity.User;
import com.upfpo.app.repository.FarmerMasterRepository;
import com.upfpo.app.repository.FpoMasterRepository;
import com.upfpo.app.repository.UserRepository;
import com.upfpo.app.util.ForgetPasswordRequest;
import com.upfpo.app.util.OTPGenerator;
import com.upfpo.app.util.OtpVerifyRequest;
import com.upfpo.app.util.PasswordReset;
import com.upfpo.app.util.Sender;
import com.upfpo.app.validators.PreLoginValidator;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private Sender send;

	@Autowired
	private OTPGenerator generateOtp;
//	
	@Autowired
	private PreLoginValidator preLoginValidator;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FpoMasterRepository fpoMasterRepository;
	@Autowired
	private FarmerMasterRepository farmerMasterRepository;

	@Override
	public ExceptionResponse generateOtp(@Valid ForgetPasswordRequest forgetPasswordRequest, HttpSession session) {

		if (checkUser(forgetPasswordRequest.getUsername(), forgetPasswordRequest.getMobileNo())) {
			char[] otp = generateOtp.OTP();
			String strOtp = new String(otp);
			try {
				Sender.sendSMS(
						"Dear" + " " + forgetPasswordRequest.getUsername() + " " + "Your OTP for Change Password is:"
								+ strOtp + " " + "Your OTP is vaild for 15 Minutes",
						forgetPasswordRequest.getMobileNo().toString());
				// send.sendMail(passwordReset.getEmail(), "OTP", "Your one time password is"+"
				// "+strOtp);
				session.setAttribute("otp", strOtp);// passwordReset.getMobNo()
				ExceptionResponse response = new ExceptionResponse();
				return response;
			} catch (Exception e) {
				e.printStackTrace();
				throw new CustomException("Error Sending Otp Please Try again Later", HttpStatus.BAD_REQUEST);
			}

		} else {
			throw new NotFoundException();
		}

	}

	@Override
	public ExceptionResponse verifyOtp(@Valid OtpVerifyRequest otpVerifyRequest, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUser(String userName, Long mobilenNumber) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			User user = null;
			Optional<User> userOpt = userRepository.findByUserNameAndIsEnabledTrueAndIsDeletedFalse(userName);
			if (userOpt.empty() == null) {
				throw new NotFoundException();
			} else {
				user = userOpt.get();
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
