/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    
        var piles_count=0;
           var piles_array=[];
           var check;
           var y1=0;
           var y2=0;
           var datastring ="0"; 
                  $("#yes1,#yes2,#yes3,#yes4,#yes5").click(function(){
                      
                    
                     
                     
                      var id =$(this).attr("id");
                      piles_array=id;
                      //alert(id);
                      if((y1===0)&&(id==="yes1"))
                      {
                         piles_count++;
                         y1=1;
                      }
                      if((y2===0)&&(id==="yes2"))
                      {
                          piles_count++;
                          y2=1;
                      }
                      //alert(piles_count);
                    // alert(id);
                     id=id.toString();
                     
                     id=id.substring(3,id.length);
                     
                     $("#row"+id).css("background-color","#8BC34A");
                     $("#row"+id).css("color","white");
                     $("#row"+id).css("font-color","green");
                      datastring =datastring+" "+id;
                      
                      
                      
                      if(piles_count===2)
                      {
                          piles_count=0;
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
                                    
                              
                            $(".right_sidebar form #row"+2).after('<div id="row'+data[i].symptom_id+'"style="border-color: #DDDDDD;border-radius: 3px;margin-bottom:5px;padding-top:5px;padding-left: 5px;">'
                                                +data[i].symptom+'&nbsp;&nbsp;<div style="float:right;"class="radiocheck">\n\
                                    <input type="radio" name="symptom'+data[i].symptom_id+'" value="'+ 0+" "+data[i].symptom_id+'" id="yes'+data[i].symptom_id+'">\n\
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
                                       
                  
                  $("#no1,#no2,#no3,#no4,#no5").click(function(){
                     if($(this)===$("#no1"))
                     {
                          check="yes1";
                     }
                     if($(this)===$("#no2"))
                     {
                          check="yes2";
                     }
                     if($(this)===$("#no3"))
                     {
                          check="yes3";
                     }
                     if($(this)===$("#no4"))
                     {
                          check="yes4";
                     }
                    for(i=0;i<piles_array.length;i++)
                     {
                         if(piles_array[i]===check)
                         {
                             piles_count--;
                             piles_array[i]=0;
                         }
                         
                     }
                     var id =$(this).attr("id");
                      id=id.toString();
                     
                     id=id.substring(2,id.length);
                 $("#row"+id).css("background-color","#FF5252");
                 $("#row"+id).css("color","white");
                     
                  });
                  $(document).on("click","#yes"+4,function(){
                    // alert("checking"+4); 
                     //$("#row"+id).css("background-color","#8BC34A");
                     // $("#row"+id).css("color","white");
                    $("#row"+4).css("background-color","#8BC34A");
                    $("#row"+4).css("color","white");
                  });
                  $(document).on("click","#yes"+3,function(){
                    
                     $("#row"+3).css("background-color","#8BC34A");
                    $("#row"+3).css("color","white");
                  });
                  $(document).on("click","#yes"+5,function(){
                    
                    $("#row"+5).css("background-color","#8BC34A");
                    $("#row"+5).css("color","white");
                  });
                  $(document).on("click","#no"+4,function(){
                    
                    $("#row"+4).css("background-color","#FF5252");
                    $("#row"+4).css("color","white");
                  });
                  $(document).on("click","#no"+3,function(){
                    
                     $("#row"+3).css("background-color","#FF5252");
                    $("#row"+3).css("color","white");
                  });
                  $(document).on("click","#no"+5,function(){
                    
                    $("#row"+5).css("background-color","#FF5252");
                    $("#row"+5).css("color","white");
                  });
});

