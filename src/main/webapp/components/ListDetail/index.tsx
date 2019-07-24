import IListDetailProps from "./IListDetailProps";
import React from "react";
import {Button, ButtonGroup} from "@blueprintjs/core";
import IListDetailState from "./IListDetailState";
import SelectableList from "../SelectableList";

class ListDetail<MODEL> extends React.Component<IListDetailProps<MODEL>, IListDetailState<MODEL>> {

    state = {
        selected: this.props.list[0]
    };

    render() {
        return (
            <div>
                <SelectableList list={this.props.list} selected={[this.state.selected]}/>
            </div>
        )
    }
}

export default ListDetail;