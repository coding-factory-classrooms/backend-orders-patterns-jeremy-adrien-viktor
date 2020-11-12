const addCode = () => {
  let value = "test";
  console.log("value");
  // let idValues = document.getElementsByClassName()
  document.getElementById("add_zone").innerHTML += `
     <p class="title">Select pizza</p>
     <div class="custom-select">
     <select class='select-css' name='pizza'>
     <option value=''>--Please choose an option--</option>
     <option value=''>SAVOUREUSE FONDUE</option>
     <option value=''>AUTHENTIQUE RACLETTE</option>
     <option value=''>Généreuse Avalanche</option>
     <option value=''>Urban Kebab</option>
     </select>
     </div>
     <div>
     
     `;
};
const test = (select) => {
  var myElem = document.getElementById("pizza_image_container");
  if (myElem === null) {
    console.log("does not exist!");
  } else {
      console.log("not null")
      var myobj = document.getElementById("pizza_image_container");
      myobj.remove();
  }
  // if(document.getElementsByClassName('pizza_image_container') == null){
  //     console.log('image container should be null')
  // }
  document.getElementById("pizza_image").innerHTML += `
    <div class="fade-in" id='pizza_image_container'>
    
    <img src='/img/${
      select.options[select.selectedIndex].text
    }.jpeg' style="width: 300px;height: 200px; object-fit: contain;margin-top:5%;">
    </div>
    </div>
    `;
};
