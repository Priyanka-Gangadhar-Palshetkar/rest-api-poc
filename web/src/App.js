import React, {useEffect, useState} from 'react';
import {Table} from 'reactstrap';
import axios from 'axios';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        async function fetchData() {
             await axios.get('http://localhost:8080/product').then(response => {
                console.log(response);
                setProducts(response.data)
                }).catch(error => 'Error!');

        }

        fetchData();

    }, [setProducts]);


  return (
    <div className="App">
        <h1>Menu</h1>
        <Table striped bordered>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                {
                    products.map((option) => (
                        <tr key={option.id}>
                            <td key={option.id}>{option.name}</td>
                            <td key={option.id}>{option.price}</td>
                        </tr>
                    ))
                }
            </tbody>
        </Table>
    </div>
  );
}

export default App;
