const hamburger = document.querySelector('.hamburger');
const bar = document.querySelector('.nav__bar');
const menu = document.querySelector('.nav__menu');
const util = document.querySelector('.nav__util');

hamburger.addEventListener('click', () => {
    bar.classList.toggle('active');
    menu.classList.toggle('active');
    util.classList.toggle('active');
});