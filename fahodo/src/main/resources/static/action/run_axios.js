async function getAddress(){
    var address = await axios.get('http://localhost:8080/book/allbooks');
    console.log(address);
}