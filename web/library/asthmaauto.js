/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
       
           var asthma_count=0;
           var asthma_array=[];
           var check;
           var y14=0;
           var y15=0;
           var y16=0;
           var datastring ="2"; 
                  $("#yes14,#yes15,#yes16").click(function(){
                      //asthma_count++;
                     
                     
                      var id =$(this).attr("id");
                       asthma_array=id;
                     if((y14===0)&&(id==="yes14"))
                     {
                         y14=1;
                         asthma_count++;
                     }
                     if((y15===0)&&(id==="yes15"))
                     {
                         y15=1;
                         asthma_count++;
                     }
                     if((y16===0)&&(id==="yes16"))
                     {
                         y16=1;
                         asthma_count++;
                     }
                       
                     
                        id=id.toString();
                        
                        id=id.substring(3,id.length);
                        datastring =datastring+" "+id;
                        $("#row"+id).css("background-color","#8BC34A");
                      $("#row"+id).css("color","white");
                     // $("#row"+id).css("font-color","green");
                      
                      
                      if(asthma_count===2)
                      {
                          asthma_count=0;
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
                                    
                               $(".right_sidebar form #row"+16).after('<div id="row'+data[i].symptom_id+'" style="border-color: #DDDDDD;border-radius: 3px;margin-bottom:5px;padding-top:5px;padding-left: 5px;">'
                                                +data[i].symptom+'&nbsp;&nbsp;<div style="float:right;"class="radiocheck">\n\
                            <input type="radio" name="symptom'+data[i].symptom_id+'" value="'+ 2+" "+data[i].symptom_id+'" id="yes'+data[i].symptom_id+'">\n\
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
                 
                  $("#no14,#no15,#no16").click(function(){
                     if($(this)===$("#no14"))
                     {
                          check="yes14";
                     }
                     if($(this)===$("#no15"))
                     {
                          check="yes15";
                     }
                     if($(this)===$("#no16"))
                     {
                          check="yes16";
                     }
                     
                    for(i=0;i<asthma_array.length;i++)
                     {
                         if(asthma_array[i]===check)
                         {
                             asthma_count--;
                             asthma_array[i]=0;
                         }
                         
                     }
                       var id =$(this).attr("id");
                      id=id.toString();
                     
                     id=id.substring(2,id.length);
                 $("#row"+id).css("background-color","#FF5252");
                 $("#row"+id).css("color","white");
                  
                     
                  });
                  $(document).on("click","#yes"+17,function()
                  {
                      $("#row"+17).css("background-color","#8BC34A");
                     $("#row"+17).css("color","white");

                  });
                  $(document).on("click","#yes"+18,function()
                  {
                      $("#row"+18).css("background-color","#8BC34A");
                     $("#row"+18).css("color","white");

                  });
                  $(document).on("click","#yes"+19,function()
                  {
                      $("#row"+19).css("background-color","#8BC34A");
                     $("#row"+19).css("color","white");

                  });
                  $(document).on("click","#yes"+20,function()
                  {
                      $("#row"+20).css("background-color","#8BC34A");
                     $("#row"+20).css("color","white");

                  });
                    $(document).on("click","#yes"+21,function()
                  {
                      $("#row"+21).css("background-color","#8BC34A");
                     $("#row"+21).css("color","white");

                  });
                  $(document).on("click","#yes"+22,function()
                  {
                      $("#row"+22).css("background-color","#8BC34A");
                     $("#row"+22).css("color","white");

                  });
                  $(document).on("click","#yes"+23,function()
                  {
                      $("#row"+23).css("background-color","#8BC34A");
                     $("#row"+23).css("color","white");

                  });
                  // for the no button clicked
                  
                  $(document).on("click","#no"+17,function()
                  {
                      $("#row"+17).css("background-color","#FF5252");
                     $("#row"+17).css("color","white");

                  });
                  $(document).on("click","#no"+18,function()
                  {
                      $("#row"+18).css("background-color","#FF5252");
                     $("#row"+18).css("color","white");

                  });
                  $(document).on("click","#no"+19,function()
                  {
                      $("#row"+19).css("background-color","#FF5252");
                     $("#row"+19).css("color","white");

                  });
                  $(document).on("click","#no"+20,function()
                  {
                      $("#row"+20).css("background-color","#FF5252");
                     $("#row"+20).css("color","white");

                  });
                    $(document).on("click","#no"+21,function()
                  {
                      $("#row"+21).css("background-color","#FF5252");
                     $("#row"+21).css("color","white");

                  });
                  $(document).on("click","#no"+22,function()
                  {
                      $("#row"+22).css("background-color","#FF5252");
                     $("#row"+22).css("color","white");

                  });
                  $(document).on("click","#no"+23,function()
                  {
                      $("#row"+23).css("background-color","#FF5252");
                     $("#row"+23).css("color","white");

                  });
});


