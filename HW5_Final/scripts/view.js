import StartMenu from './components/StartMenu.js'; 
import EasyModal from './components/EasyModal.js';    
import MediumModal from './components/MediumModal.js';  
import HardModal from './components/HardModal.js';  
import MoviesModal from './components/MoviesModal.js';  
import Modal from './components/Modal.js'; 
import GameScreen from './components/GameScreen.js'; 

const renderDOM = (html) => document.getElementById('view').innerHTML = html;   //Set HTML in view

export const StartScene = () => {
    renderDOM(
        `${StartMenu()}`
    )
}

export const ShowGameScreen = () => {
    renderDOM(
        `${GameScreen()}
        ${Modal("easy", "Easy")}
        ${Modal("medium", "Medium")}
        ${Modal("hard", "Hard")}
        ${Modal("movies", "Movie")}   
        `
    )
}

/*
        ${EasyModal()}
        ${MediumModal()}
        ${HardModal()}
        ${MoviesModal()} 

        ${Modal(easy, Easy)}
        ${Modal(medium, Medium)}
        ${Modal(hard, Hard)}
        ${Modal(movies, Movie)}
*/

