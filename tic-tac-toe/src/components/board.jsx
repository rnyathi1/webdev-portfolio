import { useState } from 'react';
import Square from './square';
function Board(){

   const [squares, setSquares] = useState(Array(9).fill(null))
    const [xIsNext,setXIsNext] = useState(true);
    const [h1Text, seth1Text] = useState("Player 1 Turn");

    function calculateWinner(){
        const lines = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6]
          ];
          for (let i = 0; i < lines.length; i++) {
            const [a, b, c] = lines[i];
            if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
              return squares[a];
            }
          }
          return null;

    }
    function handleClick(i) {
    if(squares[i]){
        return;
    } else if(calculateWinner()){
        
        if(xIsNext){
            seth1Text("Player 2 Wins");
        } else{
            seth1Text("Player 1 Wins");
        }
    } else{
        const nextSquares = squares.slice();
        if(xIsNext){
            seth1Text("Player 2 Turn");
            nextSquares[i] = 'X';
         }else{
            seth1Text("Player 1 Turn");
            nextSquares[i] = 'O';
    }
    
     setXIsNext(!xIsNext);
    setSquares(nextSquares);
    }
    
   }
   


    return(
    <div >
        <h1> {h1Text}</h1>
        <div className="board-row"  >
            <Square value ={squares[0]} onSquareClick = {() => handleClick(0)}/>
            <Square value ={squares[1]} onSquareClick = {() => handleClick(1)}/>
            <Square value ={squares[2]} onSquareClick = {() => handleClick(2)}/>
        </div>
        <div className="board-row">
            <Square value ={squares[3]} onSquareClick = {() => handleClick(3)}/>
            <Square value ={squares[4]} onSquareClick = {() => handleClick(4)}/>
            <Square value ={squares[5]} onSquareClick = {() => handleClick(5)}/>
        </div>
        <div className="board-row" >
            <Square value ={squares[6]} onSquareClick = {() => handleClick(6)}/>
            <Square value ={squares[7]} onSquareClick = {() => handleClick(7)} />
            <Square value ={squares[8]} onSquareClick = {() => handleClick(8)} />
        </div>
    </div>


    );
}

export default Board;