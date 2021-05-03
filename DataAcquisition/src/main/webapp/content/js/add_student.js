var student_id ="";


var name = "";

var surname = "";





function init_add_student()

{
	console.log("init_add_student called");
	
	student_id = create_primary_id();
	
	$("#student_id_input").val(student_id);
	
	$(".save_btn").click(function(){
		
		save_btn_click();
		
	});
	
}

function save_btn_click()
{
    
	var promises = [];
		
	promises.push(validate_name("#student_name_input",true));
	promises.push(validate_name("#student_surname_input",true));
	
	Promise
		.all(promises)
        .then((data) => {
			
			console.log("41"+data);
			
			
			
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

								Promise.all([set_student()]).then(function ([data]){
									
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
				set_student();
				}
				
			}
	
	});
	
}

function set_student()
{
	var data = {'message':'error'};
	
	var deferred = new $.Deferred();
	

	$.ajax({
		type: "POST",
	    url: "student/add",	    
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






