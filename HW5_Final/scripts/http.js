export const sendGETRequest = async (url) => { //Asynchronous function
    const options = new Object(); //Empty object for HTTP options
    options.method = "GET"; //HTTP method: GET
    /*options.headers = {
        'X-RapidAPI-Host': 'pictionary-charades-word-generator.p.rapidapi.com',
        'X-RapidAPI-Key': '612169b249msh7b716264d24c315p167619jsn6978eb5cb2d9'
    };*/

    const response = await fetch(url, options); //Send request with fetch (wait)
    const data = await response.json(); //Extract json from response (wait)
    //console.log(data);
    return data //return data as an Object
}
