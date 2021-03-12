package com.upfpo.app.service;

import com.upfpo.app.entity.*;
import com.upfpo.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FpoMasterRepository fpoMasterRepository;

    @Autowired
    private FarmerRegisterRepo farmerRepository;

    @Autowired
    private BuyerSellerRepository buyerSellerRepository;

    @Autowired
    private InputSupplierMasterRepository inputSupplierRepository;

    @Autowired
    private ChcFmbMasterRepository chcFmbRepository;





   /* public User changePassword (User user){


    }*/


    @Override
    public Object resetPasswordByUserName(String username){
        User existingUser = userRepository.findByUserName(username);

        if(existingUser!=null){
            if(existingUser.getRoleRefId().equals("4")){
                FPORegister fpo = fpoMasterRepository.findByUserFpo(existingUser.getUserId());
                return fpo;
            }else  if(existingUser.getRoleRefId().equals("6")){
                FarmerRegister farmer = farmerRepository.findByUserRefId(existingUser.getUserId());
                return farmer;
            }else  if(existingUser.getRoleRefId().equals("2")){
                BuyerSellerMaster buyerSeller = buyerSellerRepository.findByUserBuyerSeller(existingUser.getUserId());
                return buyerSeller;
            }else  if(existingUser.getRoleRefId().equals("3")){
                InputSupplierMaster inputSupplier = inputSupplierRepository.findByUserInputSeller(existingUser.getUserId());
                return inputSupplier;
            }else{
                ChcFmbMaster chcFmb = chcFmbRepository.findByUser(existingUser.getUserId());
                return chcFmb;
            }
        }


        return "User not found";

    }
}
