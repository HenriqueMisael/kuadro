import { Alignment, Button, Navbar, Popover, Position } from "@blueprintjs/core";
import React from "react";
import { BrowserRouter as Router, Link, Route } from "react-router-dom";
import './App.css';
import CardTypeIndex from "./components/card-type/index";
import Home from "./components/home";
import PhaseIndex from "./components/phase";
import SettingsMenu from "./components/settings-menu";

const App: React.FC = () => {
  return (
    <Router>
      <div>
        <Navbar>
          <Navbar.Group align={Alignment.LEFT}>
            <Navbar.Heading><Link to="/" ><Button className="bp3-minimal" text="Kuadro" /></Link></Navbar.Heading>
            <Navbar.Divider />
            <Popover content={<SettingsMenu />} position={Position.BOTTOM}>
              <Button className="bp3-minimal" icon="settings" text="Preferences" />
            </Popover>
          </Navbar.Group>
        </Navbar>

        <Route exact path="/" component={Home} />
        <Route path="/card-type" component={CardTypeIndex} />
        <Route path="/phase" component={PhaseIndex} />
      </div>
    </Router>
  );
}

export default App;
