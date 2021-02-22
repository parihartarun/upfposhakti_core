package com.upfpo.app.upagri;

import com.upfpo.app.dto.UpAgriDataDto;

public interface UpAgriService {

	UpAgriDataDto getUpAgriData(String _anydist, String _blck, String _vill);

	
}
