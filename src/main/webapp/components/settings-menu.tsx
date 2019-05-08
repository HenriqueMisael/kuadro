import { Button, Menu } from "@blueprintjs/core";
import React from "react";
import { Link } from "react-router-dom";

export default () => {
    return (
        <Menu>
            <Menu.Item icon="document" text="Card Type" href="/card-type" />
            <Menu.Item icon="layers" text="Phase" href="/phase" />
        </Menu>
    )
}
