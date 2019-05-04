import { Alignment, Button, Navbar } from "@blueprintjs/core";
import React from "react";
import { BrowserRouter as Router, Link, Route } from "react-router-dom";
import './App.css';
import CardTypeIndex from "./components/card-type/index";
import Home from "./components/home";

const App: React.FC = () => {
  return (
    <Router>
      <div>
        <Navbar>
          <Navbar.Group align={Alignment.LEFT}>
            <Navbar.Heading>Kuadro</Navbar.Heading>
            <Navbar.Divider />
            <Link to="/" ><Button className="bp3-minimal" icon="home" text="Home" /></Link>
            <Link to="/card-type"><Button className="bp3-minimal" icon="document" text="Card Type" /></Link>
          </Navbar.Group>
        </Navbar>

        <Route exact path="/" component={Home} />
        <Route path="/card-type" component={CardTypeIndex} />
      </div>
    </Router>
  );
}

export default App;
