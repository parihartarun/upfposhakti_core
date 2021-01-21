function getdistrict() {
	var state_id = $('#stateref').val();
	
	$.ajax({
		url : 'getDistrictList',
		type : 'GET',
		data : {
			'state_id' : state_id
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			parseInt(j);

			if (j == null) {
				$("#distref").empty();
			} else {
				$("#distref").empty();
				var state = '<option value=>Select District</option>';
				parseInt(state);
				for (var i = 0; i < j.length; i++) {
					state += '<option value=' + j[i].district_id + '>'
							+ j[i].district_name + '</option>'
				}
				$("#distref").append(state);
				
			}
		},
		error : function(data, status) {
		}

	});
}

function getDistByFPO() {

	var fpoId = $('#fpoRefId').val();
	if(fpoId ==-1)
		{
		var state_id = $('#stateref').val();
		$.ajax({
			url : 'getDistrictList',
			type : 'GET',
			data : {
				'state_id' : state_id
			},
			success : function(data, status) {
				var j = JSON.parse(data);
				parseInt(j);

				if (j == null) {
					$("#distref").empty();
				} else {
					$("#distref").empty();
					var state = '<option value=>Select District</option>';
					parseInt(state);
					for (var i = 0; i < j.length; i++) {
						state += '<option value=' + j[i].district_id + '>'
								+ j[i].district_name + '</option>'
						parseInt(state);
					}
					$("#distref").append(state);
				}
			},
			error : function(data, status) {
			}

		});
		
		}
	$.ajax({

		url : 'getDistByFPOId',
		type : 'GET',
		data : {
			'fpoId' : fpoId
		},
		success : function(data, status) {
			var j = JSON.parse(data);

			if (j == null) {
				$("#distref").empty();
			} else {

				$("#distref").empty();
				var dist = '<option value=>Select District</option>';
				for (var i = 0; i < j.length; i++) {
					dist += '<option value=' + j[i].district_id + '>'
							+ j[i].district_name + '</option>'
				}
				$("#distref").append(dist);
			}
		},
		error : function(data, status) {
		}
	});
}

function getFPCs() {
	var dist = $('#slaref').val();
	$.ajax({
		url : 'getfpcbyslaid',
		type : 'GET',
		data : {
			'dist' : dist
		},
		success : function(data, status) {
			var j = JSON.parse(data);

			if (j == null) {
				$("#fpoRefId").empty();
			} else {
				$("#fpoRefId").empty();
				var state = '<option value=>Select FPO/FPC</option>';
			     state = state + '<option value=-1>Not Registred yet</option>';
				for (var i = 0; i < j.length; i++) {

					state += '<option value=' + j[i].fpoId + '>' + j[i].fpoName
							+ '</option>'
				}
				$("#fpoRefId").append(state);
			}
		},
		error : function(data, status) {
		}
	});
}

function getVillages() {

	var blockId = $('#villagePanchayatId').val();

	$.ajax({
		url : 'villages',
		type : 'GET',
		data : {
			'blockId' : blockId
		},
		success : function(data, status) {
			var j = JSON.parse(data);

			if (j == null) {
				$("#villRefId").empty();
			} else {
				$("#villRefId").empty();
				var villages = '<option value=>Select Village</option>';
				for (var i = 0; i < j.length; i++) {

					villages += '<option value=' + j[i].villageId + '>'
							+ j[i].villageName + '</option>'
				}

				$("#villRefId").append(villages);
			}

		},
		error : function(data, status) {

		}

	});
}

function getFigs() {

	var fig = $('#fpoRefId').val();

	$.ajax({
		url : 'getFigList',
		type : 'GET',
		data : {
			'fig' : fig
		},
		success : function(data, status) {
			var j = JSON.parse(data);

			if (j == null) {
				$("#figRefId").empty();

			} else {
				$("#figRefId").empty();
				var figs = '<option value=>Select FIG</option>';
				figs += '<option value=-1>Yet To be Registered</option>'
				for (var i = 0; i < j.length; i++) {

					figs += '<option value=' + j[i].figId + '>' + j[i].figName
							+ '</option>'
							figs += '<option value=-1>Not Registered Yet</option>';
				}

				$("#figRefId").append(figs);
			}

		},
		error : function(data, status) {

		}

	});
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode
			
	if (charCode != 46 && charCode > 32 && (charCode < 48 || charCode > 57) || (charCode == 32) ) {
		
		return false;
	}
	return true;
}
/*
function validateEmail(emailField) {
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

	if (reg.test(emailField.value) == false) {
		alert('Invalid Email Address');
		emailField.value = "";
		return false;
	}

	return true;
}
*/

function getBlock() {
	
	var distId = $('#distref').val();
	sessionStorage.setItem("selValue",distId);
		
	$.ajax({
		url : 'getBlockList',
		type : 'GET',
		data : {
			'distId' : distId
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			parseInt(j);

			if (j == null) {
				$("#blockRefId").empty();
			} else {
				$("#blockRefId").empty();
				var block = '<option value=>Select Block</option>';
				parseInt(block);
				for (var i = 0; i < j.length; i++) {

					block += '<option value=' + j[i].id + '>' + j[i].blockNameHi
							+ '</option>'
							
					parseInt(block);
				}
				$("#blockRefId").append(block);
			}
		},
		error : function(data, status) {
		}
	});
}

function getSLAByStateId() {
	var stateId = $('#stateref').val();
	$.ajax({
		url : 'getSlaList',
		type : 'GET',
		data : {
			'stateId' : stateId
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			parseInt(j);
			if (j == null) {
				$("#slaref").empty();
			} else {
				$("#slaref").empty();
				var slas = '<option value=>Select SLA</option>';
				parseInt(slas);
				for (var i = 0; i < j.length; i++) {
					slas += '<option value=' + j[i].sla_id + '>'
							+ j[i].unitAsSLA + '</option>';
				}
				$("#slaref").append(slas);
			}
		},
		error : function(data, status) {

		}

	});
}

function checkChar(e) {
	
	var k;
    document.all ? k = e.keyCode : k = e.which;
    return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57));
}


function checkAddress(e) {
	var k;
    document.all ? k = e.keyCode : k = e.which;
    return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 47 && k <= 57)||k==45||k==058||k==44);
}

function isValidUser(e) {
	var k;
    document.all ? k = e.keyCode : k = e.which;
    return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || (k >= 48 && k <= 57)||k==095);
}

function checkAvailability() {
	var userName = $('#uid').val();
	
	if (userName.length < 8) {
		$("#avail_resp").html("Username Should be atleast 8 Characters"+userName);
		$("#avail_resp").css("color", "red");
		$("#uid").css("border", "solid red");
		$("#btnSubmit").attr("disabled", true);
	} else {
		$.ajax({
			url : 'checkAvailability',
			type : 'GET',
			data : {
				'userName' : userName
			},
			success : function(data) {

				if (data == "This Username is Already taken by other User") {
					$("#avail_resp").html(data);
					$("#avail_resp").css("color", "red");
					$("#uid").css("border", "solid red");
					$("#btnSubmit").attr("disabled", true);
				} else {
					$("#avail_resp").html(data);
					$("#avail_resp").css("color", "green");
					$("#uid").css("border", "solid green");
					$("#btnSubmit").attr("disabled", false);
				}
			}

		});
	}
}

function validateAadhaar() {
	var adhar = $("#adhaarId").val();
	var len = adhar.length;
 	if(len=0)
 		{
 		
 		}
 	else if(len>0|| len!=12 || len!=16)
		{
		$("#adhaar_resp").html("Please Enter Valid 12 Digit Aadhaar Number");
		$("#adhaar_resp").css("color", "red");
		$("#btnSubmit").attr("disabled", true);
		}
	
	$.ajax({
		url : 'checkAadhaar',
		type : 'GET',
		data : {
			'adhar' : adhar
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			
			if (j == true) {
				$(adhaarId).css("border", "solid green");
			//	$("#").css("background-color", "green");
				$("#btnSubmit").attr("disabled", false);
				$("#adhaar_resp").hide();
			} 
			
			else {
				$("#adhaar_resp").show();
				$(adhaarId).css("border", "solid red");
				$("#btnSubmit").attr("disabled", true);
			}
		}
	});
}

function getLand() {

	var land = $('#seasonRefName').val();
	$.ajax({
		url : 'getlandbyfarmerId',
		type : 'GET',
		data : {
			'land' : land
		},
		success : function(data) {
			$("#landleft").val(parseFloat(data.replace('"', '')));
		}

	});
}


function crops()
{
	var cropTypeId = $('#cropType').val();
	var seasonId =  $('#seasonRefName').val();
	
	$.ajax({
		url : 'cropsByCategory',
		type : 'GET',
		data : {
			'cropTypeId' : cropTypeId,'seasonId':seasonId
		},
		success : function(data, status) {
			var j = JSON.parse(data);

			if (j == null) {
				$("#cropRefId").empty();
			} else {
				$("#cropRefId").empty();
				var crops = '<option value=>Select Crop</option>';
				for (var i = 0; i < j.length; i++) {
					crops += '<option value=' + j[i].cropId + '>'
							+ j[i].cropName + '</option>'
				}
				$("#cropRefId").append(crops);
			}
		},
		error : function(data, status) {
		}

	});
	}

function getCropsForProduction()
{
	var cropTypeId = $('#cropType').val();
	var seasonId =  $('#seasonRefName').val();
	var farmerId=$('#farmer_iddd').val();
	var landId=$('#landid').val();
	var finYear=$('#financialYear').val();
	//alert("cropTypeId:"+cropTypeId+"seasonId:"+seasonId+"farmerId:"+farmerId+"landId:"+landId+"finYear:"+finYear);
	$.ajax({
		url : 'cropsBySowingDetails',
		type : 'GET',
		data : {
			'cropTypeId' : cropTypeId,'seasonId':seasonId,'farmerId':farmerId,'landId':landId,'finYear':finYear 
		},
		success : function(data, status) {
			var j = JSON.parse(data);

			if (j == null) {
				$("#cropRefId").empty();
			} else {
				$("#cropRefId").empty();
				var crops = '<option value=>Select Crop</option>';
				for (var i = 0; i < j.length; i++) {
					crops += '<option value=' + j[i].cropId + '>'
							+ j[i].cropName + '</option>'
				}
				$("#cropRefId").append(crops);
			}
		},
		error : function(data, status) {
		}

	});
	}

function getcategoryforProduction()
{
	//var cropTypeId = $('#cropType').val();
	var seasonId =  $('#seasonRefName').val();
	var farmerId=$('#farmer_iddd').val();
	var landId=$('#landid').val();
	var finYear=$('#financialYear').val();
	//alert("seasonId:"+seasonId+"farmerId:"+farmerId+"landId:"+landId+"finYear:"+finYear);
	$.ajax({
		url : 'categoryforProduction',
		type : 'GET',
		data : {
			'seasonId':seasonId,'farmerId':farmerId,'landId':landId,'finYear':finYear 
		},
		success : function(data, status) {
			var j = JSON.parse(data);

			if (j == null) {
				$("#cropType").empty();
			} else {
				$("#cropType").empty();
				var crops = '<option value=>Select Crop Category</option>';
				for (var i = 0; i < j.length; i++) {
					crops += '<option value=' + j[i].id + '>'
							+ j[i].cropType + '</option>'
				}
				$("#cropType").append(crops);
			}
		},
		error : function(data, status) {
		}

	});
	}



function getCropVeriety()
{
	var cropId = $('#cropRefId').val();
	
	$.ajax({
		url : 'verieties',
		type : 'GET',
		data : {
			'cropId' :cropId
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			if (j == null) 
			{
				$("#verietyRef").empty();
			}
			else
			{
				$("#verietyRef").empty();
				var verieties = '<option value=>Select Crop Variety</option>';
				
				for (var i = 0; i < j.length; i++) {
					
					verieties += '<option value=' + j[i].verietyId + '>'
							+ j[i].verietyName + '</option>'
				}
				verieties += '<option value='+'0'+'>Other</option>';
				$("#verietyRef").append(verieties);
			}
		},
		error : function(data, status) {
		}
	});
}

function getCropVerietyforProduction()
{
	var cropId = $('#cropRefId').val();
	var cropTypeId = $('#cropType').val();
	var seasonId =  $('#seasonRefName').val();
	var farmerId=$('#farmer_iddd').val();
	var landId=$('#landid').val();
	var finYear=$('#financialYear').val();
	//alert("seasonId:"+seasonId+"farmerId:"+farmerId+"landId:"+landId+"finYear:"+finYear +"cropId:"+ cropId) ;
	$.ajax({
		url : 'verietiesforProduction',
		type : 'GET',
		data : {
			'cropId' :cropId, 'seasonId':seasonId,'farmerId':farmerId,'landId':landId,'finYear':finYear, 'cropTypeId':cropTypeId
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			if (j == null) 
			{
				//$("#verietyRef").empty();
				verieties = '<option value='+'0'+'>Other</option>';
			}
			else
			{
				$("#verietyRef").empty();
				var verieties = '<option value=>Select Crop Variety</option>';
				if(j.length>0)
					{
				for (var i = 0; i < j.length; i++) {
					verieties += '<option value=' + j[i].verietyId + '>'
							+ j[i].verietyName + '</option>'
				}
					}
				else
					{verieties = '<option value='+'0'+'>Other</option>';
					
					}
				//verieties += '<option value='+'0'+'>Other</option>';
				$("#verietyRef").append(verieties);
			}
		},
		error : function(data, status) {
		}
	});
}

function getCropsBySeason()
{
	
var seasonId = $('#seasonref').val();
//	alert("seasonId:"+ seasonId);
	$.ajax({
		url : 'cropsBySeason',
		type : 'GET',
		data : {
			'seasonId' :seasonId
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			if (j == null) 
			{
				$("#cropRefId").empty();
			}
			else
			{
				$("#cropRefId").empty();
				var crops = '<option value=>Select Crop</option>';
				crops += '<option value=0>All Crop</option>';
				for (var i = 0; i < j.length; i++) {
					
					crops += '<option value=' + j[i].cropId + '>'
							+ j[i].cropName + '</option>'
				}
				$("#cropRefId").append(crops);
			}
		},
		error : function(data, status) {
		}
	});
}


function getCropsBySeason1()
{
	
var seasonId = $('#seasonref').val();
	//alert("seasonId:"+ seasonId);
	$.ajax({
		url : 'cropsBySeason',
		type : 'GET',
		data : {
			'seasonId' :seasonId
		},
		success : function(data, status) {
			var j = JSON.parse(data);
			if (j == null) 
			{
				$("#cropRefId").empty();
			}
			else
			{
				$("#cropRefId").empty();
				var crops = '<option value=>Select Crop</option>';
				
				for (var i = 0; i < j.length; i++) {
					
					crops += '<option value=' + j[i].cropId + '>'
							+ j[i].cropName + '</option>'
				}
				$("#cropRefId").append(crops);
			}
		},
		error : function(data, status) {
		}
	});
}

function getPanchayats()
{
		var blockId = $('#blockRefId').val();
		$.ajax({
			url : 'get_panchayats',
			type : 'GET',
			data : {
				'blockId' : blockId
			},
			success : function(data, status) {
				var j = JSON.parse(data);

				if (j == null) {
					$("#villagePanchayatId").empty();
				} else {
					$("#villagePanchayatId").empty();
					var villages = '<option value=>Select Panchayat</option>';
					for (var i = 0; i < j.length; i++) {

						villages += '<option value=' + j[i].panchayat_id + '>'
								+ j[i].panchayat_name + '</option>'
					}

					$("#villagePanchayatId").append(villages);
				}
			},
			error : function(data, status) {
			}
		});
	}

/*Amit Singh
Date 11-10-2020
Method Added for search functionality at home page
*/ 

function getsearchathome() {
		
	var search_value = $('#homesearch').val();
	var search_in =$('#searchin').val();
	//alert("Home Search Called for: "+ search_value );
	var base_url = window.location.origin + "/UPAGRI-AREA";
	document.location.href=base_url+"/gethomesearch?search_value=" +search_value +"&search_in="+search_in;
}
