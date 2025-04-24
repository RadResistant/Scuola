async function prova(){
    let oggetto={nome:"asfadg"};
    let richiesta=await fetch("http://localhost:8280/hotel/1",{
        method:'PUT',
        headers:{'Content-Type': 'application/json'},
        body:JSON.stringify(oggetto)
    });
    // let richiesta=await fetch("http://localhost:8080/todo/8",{method:'DELETE'});
    let as=document.getElementsByTagName("body")[0];
    console.log(richiesta)
}