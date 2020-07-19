// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I play piano.', "I don't like raw tomatoes.", 'My favorite color is coral orange.', 'My go to Starbucks order is strawberry acai refresher.'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  console.log('how do i see this text 55556565');

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

var slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("slide");
  var dots = document.getElementsByClassName("demo");
  var captionText = document.getElementById("caption");
  if (n > slides.length){slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
  captionText.innerHTML = dots[slideIndex-1].alt;
}

/** 
* getDataServletArrow fetches content from DataServlet and adds it to the page
 */
function getDataServletArrow() {
    fetch('/data').then(response => response.text()).then((data) => {
        document.getElementById("data-container").innerText = data;
    });
}

/**
* getCommentJSON fetches comment (as a JSON string) contained in DataServlet
 */
function getCommentJSON() {
    fetch('/data').then(response => response.json()).then((data) => {

        const commentListElement = document.getElementById('comments-container');
        commentListElement.innerHTML = '';
        commentListElement.appendChild(
            createListElement('Comment: ' + data.Comment));
    });
}

/** createComment makes an <li> element containing comments. */
function createComment(comments) {
  const comElement = document.createElement('li');
  comElement.innerText = comments;
  return comElement;
}
