// const express=require('express');
// const app= express();


// app.use(express.urlencoded({extended:true}));
// app.use(express.json());


// app.use('/',(req,res)=>{
//     res.send('hello world');
//     console.log('hello world');
// })


// app.listen(58887,()=>{
//     console.log('server started');
// })


function asynTaskOne(){
    setTimeout(()=>{
        console.log('task one  is finished');
    },3000)
}

function asynTaskTwo(){
    setTimeout(()=>{
        console.log('task two  is finished');
    },1000)
}
console.log('start');
asynTaskOne();
console.log('middle');
asynTaskTwo();

