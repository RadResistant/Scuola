async function prova(){
    let oggetto={
        isbn:"978-3-16-148410-0",
        titolo:"L'amore della mia vita Edoardo Panfili",
        autore:"Raffaele",
        prestabile:1};
    let richiesta=await fetch("http://localhost:8080/libri",{
        method:'POST',
        headers:{'Content-Type': 'application/json'},
        body:JSON.stringify(oggetto)
    });
}
prova();