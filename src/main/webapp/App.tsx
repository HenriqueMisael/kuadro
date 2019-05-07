import { Alignment, Button, Menu, Navbar, Popover, Position } from "@blueprintjs/core";
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
            <Navbar.Heading><Link to="/" ><Button className="bp3-minimal" text="Kuadro" /></Link></Navbar.Heading>
            <Navbar.Divider />
            <Popover content={<Menu><Link to="/card-type"><Button className="bp3-minimal" icon="document" text="Card Type" /></Link></Menu>} position={Position.BOTTOM}>
            <Button className="bp3-minimal" icon="menu" text="Workflow" />
            </Popover>
          </Navbar.Group>
        </Navbar>

        <Route exact path="/" component={Home} />
        <Route path="/card-type" component={CardTypeIndex} />
      </div>
    </Router>
  );
}

export default App;
