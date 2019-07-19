import IListDetailProps from "./IListDetailProps";
import React from "react";
import {Button, ButtonGroup} from "@blueprintjs/core";
import IListDetailState from "./IListDetailState";

class ListDetail extends React.Component<IListDetailProps, IListDetailState> {

    state = {
        selected: {}
    };

    render() {
        return (
            <div>
                <ButtonGroup vertical={true} minimal={true}>
                    {this.props.list.map(item => <Button active={item === this.state.selected}
                                                         onClick={() => this.setState({selected: item})}>{item.name}</Button>)}
                </ButtonGroup>
            </div>
        )
    }
}

export default ListDetail;