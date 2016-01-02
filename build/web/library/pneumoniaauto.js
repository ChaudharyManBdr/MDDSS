/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
       
           var pneumonia_count=0;
           var pneumonia_array=[];
           var check;
           var y6=0;
           var y7=0;
           var y8=0;
           var datastring ="1"; 
                  $("#yes6,#yes7,#yes8").click(function(){
                      //pneumonia_count++;
                     
                     
                     
                      var id =$(this).attr("id");
                       pneumonia_array=id;
                       
                     if((y6===0)&&(id==="yes6"))
                     {
                         y6=1;
                         pneumonia_count++;
                     }
                     if((y7===0)&&(id==="yes7"))
                     {
                         y7=1;
                         pneumonia_count++;
                     }
                     if((y8===0)&&(id==="yes8"))
                     {
                         y8=1;
                         pneumonia_count++;
                     }
                        id=id.toString();
                        
                        id=id.substring(3,id.length);
                        datastring =datastring+" "+id;
                      $("#row"+id).css("background-color","#8BC34A");
                      $("#row"+id).css("color","white");
 
                      
                      
                      if(pneumonia_count===2)
                      {
                          pneumonia_count=0;
                          datastring='data='+datastring;
                          
                          $.ajax({
                            type:"POST",
                            url:"fetchsymptom",
                            data: datastring,
                            cache: false,
                            success: function(data)
                            {
                     
                                for(var i=0;i<data.length;i++)
                                {
                                    
                               $(".right_sidebar form #row"+8).after('<div id="row'+data[i].symptom_id+'" style="border-color: #DDDDDD;border-radius: 3px;margin-bottom:5px;padding-top:5px;padding-left: 5px;">'
                                                +data[i].symptom+'&nbsp;&nbsp;<div style="float:right;"class="radiocheck">\n\
                            <input type="radio" name="symptom'+data[i].symptom_id+'" value="'+ 1+" "+data[i].symptom_id+'" id="yes'+data[i].symptom_id+'">\n\
                                            <label for="yes'+data[i].symptom_id+'">Yes</label>\n\
                                            <input type="radio" name="symptom'+data[i].symptom_id+'"  value="null" id="no'+data[i].symptom_id+'">\n\
                                <label for="no'+data[i].symptom_id+'">No</label>&nbsp;&nbsp;</div><br/><br/></div>');
                                } 
                                
                                // loop for adding the symptoms in the symptoms.
                            }
			});
                        //end of the ajax.
                      }
                      //end of if statement.
                  });
                 
                  $("#no6,#no7,#no8").click(function(){
                     if($(this)===$("#no6"))
                     {
                          check="yes6";
                     }
                     if($(this)===$("#no7"))
                     {
                          check="yes7";
                     }
                     if($(this)===$("#no8"))
                     {
                          check="yes8";
                     }
                     
                    for(i=0;i<pneumonia_array.length;i++)
                     {
                         if(pneumonia_array[i]===check)
                         {
                             pneumonia_count--;
                             pneumonia_array[i]=0;
                         }
                         
                     }
                      var id =$(this).attr("id");
                      id=id.toString();
                     
                     id=id.substring(2,id.length);
                 $("#row"+id).css("background-color","#FF5252");
                 $("#row"+id).css("color","white");
 
                   
                     
                  });
                  
                  $(document).on("click","#yes"+9,function(){
                    $("#row"+9).css("background-color","#8BC34A");
                    $("#row"+9).css("color","white");
                  });
                  $(document).on("click","#yes"+10,function(){
                    $("#row"+10).css("background-color","#8BC34A");
                    $("#row"+10).css("color","white");
                  });
                  $(document).on("click","#yes"+11,function(){
                    $("#row"+11).css("background-color","#8BC34A");
                    $("#row"+11).css("color","white");
                  });
                  $(document).on("click","#yes"+12,function(){
                    $("#row"+12).css("background-color","#8BC34A");
                    $("#row"+12).css("color","white");
                  });
                  $(document).on("click","#yes"+13,function(){
                    $("#row"+13).css("background-color","#8BC34A");
                    $("#row"+13).css("color","white");
                  });
                                   
    /// clicking no button
                   $(document).on("click","#no"+9,function(){
                    $("#row"+9).css("background-color","#FF5252");
                    $("#row"+9).css("color","white");
                });
                $(document).on("click","#no"+10,function(){
                    $("#row"+10).css("background-color","#FF5252");
                    $("#row"+10).css("color","white");
                });
                $(document).on("click","#no"+11,function(){
                    $("#row"+11).css("background-color","#FF5252");
                    $("#row"+11).css("color","white");
                });
                $(document).on("click","#no"+12,function(){
                    $("#row"+12).css("background-color","#FF5252");
                    $("#row"+12).css("color","white");
                });
                
                $(document).on("click","#no"+13,function(){
                    $("#row"+13).css("background-color","#FF5252");
                    $("#row"+13).css("color","white");
                });
    
});


