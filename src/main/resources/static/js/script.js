const addSelectHtml = (string,idValue) => {
  let value = "test";
  console.log("value",string);
  // let idValues = document.getElementsByClassName()
  document.getElementById(`${idValue}`).innerHTML += `
     <p class="title">Select pizza</p>
     <div class="custom-select">
     <select class='select-css' name='pizza'>
     <option value=''>${string}</option>
     </select>
     </div>
     <div>
     
     `;
};

const handlePizzaImage = (select,imageParentContainer,imageContainerName) => {
  var myElem = document.getElementById(`${imageContainerName}`);
  if (myElem === null) {
    console.log("does not exist!");
  } else {
      console.log("not null")
      var myobj = document.getElementById(`${imageContainerName}`);
      myobj.remove();
  }
  // if(document.getElementsByClassName('pizza_image_container') == null){
  //     console.log('image container should be null')
  // }
  document.getElementById(`${imageParentContainer}`).innerHTML += `
    <div class="fade-in" id='${imageContainerName}'>
    <img src='/img/${
      select.options[select.selectedIndex].text
    }.jpeg' style="width: 300px;height: 200px; object-fit: contain;margin-top:5%;">
    </div>
    </div>
    `;
};
