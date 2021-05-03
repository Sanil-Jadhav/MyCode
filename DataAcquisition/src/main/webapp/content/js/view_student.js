
saved = false;

var student_data = null;



var name = "";

var surname = "";

function init_view_student()
{

	Promise.all([get_student_by_id()]).then(function ([data]){

		student_data = data.student_list[0];
		
		if ((data.message=="error")||(data.message=="not_found")){
			
			draw_modal_centered("Error","Something went wrong. Student Id is not found ");

		}
		else{
			
			
			$("#student_id_input").val(student_data.id);			
			$("#student_name_input").val(student_data.name);			
			$("#student_surname_input").val(student_data.surname);			

        }
	
	}); 
	
	$(".update_btn").click(function(){
		
		update_btn_click();

	});
	
}


function update_btn_click()
{

	var promises = [];
		
	promises.push(validate_name("#student_name_input",true));
	promises.push(validate_name("#student_surname_input",true));
	
	Promise
		.all(promises)
        .then((data) => {
			
			console.log(data);
			
			
			
			for(var i=0; i<data.length; i++){
				
				if (!data[i][0]){
					
					console.log("error: validation");
					
					return;
				}
				
				
				
				if(i+1==data.length){
					
					name = $("#student_name_input").val().replace(/\s\s+/g, ' ').trim();
					
					surname = $("#student_surname_input").val().replace(/\s\s+/g, ' ').trim();
										
/*        		Promise.all([upload_files_sequentially(), delete_files_sequentially()])
							.then(function ([data]){ 

								Promise.all([update_student()]).then(function ([data]){
									
									if (data.message=="error"){
										
								    	setTimeout(function(){ $(".add_save span i").attr("class", "fas fa-exclamation"); }, 1000);
						
									}
									else{
										
										$(".add_save span i").attr("class", "fas fa-check");
										
										setTimeout(function(){
											
											}, 1000);
						
									}
								
								});
								
					}); 
*/					
				update_student();
				}
				
			}
	
	});
	
}
function get_student_by_id()
{
    var deferred = new $.Deferred();
    
    var data = {'message':'error'};
    
	$.ajax({
		type: "POST",
	    url: "student/get/by/id",	    
	    contentType: "application/json;charset=utf-8",
	    dataType: "json",
	    data:  JSON.stringify({ 
	    	
	    	"id" : student_id,

	    }),	    
	    success: function(data)
	    {
	    	
	    	console.log(data);
	    	
	    	deferred.resolve(data);
	    
	    },
	    error: function () {
	    	

			console.log("error ");

	   
	      
	    	deferred.resolve(data);
	    }
	});
	
	return deferred.promise();
}

function update_student()
{
	var data = {'message':'error'};
	
	var deferred = new $.Deferred();
	

	$.ajax({
		type: "POST",
	    url: "student/update",	    
	    contentType: "application/json;charset=utf-8",
	    dataType: "json",
	    data:  JSON.stringify({ 
	    	
	    	"id" : student_id,
	    	"name":  name,
	    	"surname":  surname,

	    }),	    
	    success: function(data)
	    {
	    	
	    	console.log(data);
			deferred.resolve(data);
	    	
	    },
	    error: function () {
	    	

			console.log("error");
			deferred.rejected(new error("error caught"));
	    	}
	});
	
	return deferred.promise() ;
}

