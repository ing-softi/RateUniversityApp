window.addEventListener("load",getData,false);

var courses;
function start(data){
  var courseRef=document.getElementById("pro-container");
  if (data==false){
      courseRef.innerHTML+="<h5>...Apologies, but there was an error while retrieving the data. Please try again later. Thank you for your understanding.</h5>"
      return;
    }
  courses=data;
    for(var course of courses){
        var stars="";
        for(var i=0;i<course.averageRates;i++)
        stars=stars+"<i class='fas fa-star'></i>";
        courseRef.innerHTML +=`
        <div class="pro">
			<img src="img/courses/`+course.name +`.png" alt="">
			<div class="des">
				<span>`+course.weekDay +` `+course.startTime+`-`+course.endTime+`</span>
				<h5>`+course.name +`</h5>
				<div class="star">`+stars+`</div>
				
				<h4>Prof.`+course.professor +`</h4>
			</div>
			<a href="#"><i class="fal fa-clipboard-user cart"></i></a>

		</div>`;
    }
    registerToACourse();
}

function getData(){
  $.ajax({
    type:"GET",
    url:"http://localhost:8080/courses", 
    success: function(data){
        console.log(data);
        start(data);
    },
    error: function(err){
      console.log(err);
      start(false);
    }

  });
}

function registerToACourse(){
  let carts= document.querySelectorAll('.fa-clipboard-user');
  //carts[1] kap  produktin e dyte tek screeni
  for(let i=0; i<carts.length;i++){
    carts[i].addEventListener('click',()=>{
        console.log(' u shtua ne shport'+i);
        localStorage.setItem("selectedCourse",JSON.stringify(courses[i]));
    })
  }
}

const search = () => {
  const searchBox = document.getElementById("search-item").value.toUpperCase();
  const storeItems = document.getElementById("pro-container");
  const product = document.querySelectorAll(".pro");
  const pname = document.getElementsByTagName("h5");

  for (var i = 0; i < pname.length; i++) {
      let match = product[i].getElementsByTagName("h5")[0];
      if (match) {
          let textValue = match.textContent || match.innerHTML;
          if (textValue.toUpperCase().indexOf(searchBox) > -1) {
              product[i].style.display = "";
          } else {
              product[i].style.display = "none";
          }
      }
  }
}