import { H1, Toaster, Position } from "@blueprintjs/core";
import "@blueprintjs/core/lib/css/blueprint.css";
import { Cell, Column, Table } from "@blueprintjs/table";
import "@blueprintjs/table/lib/css/table.css";
import React from "react";
import cardTypeService from "../../model/card-type/service";
import CardTypeModel from "../../model/card-type/model";

export default class CardTypeIndex extends React.Component {

    state = {
        list: [] as CardTypeModel[]
    }

    render() {
        return <div>
            <H1>Card Types</H1>
            <Table numRows={this.state.list.length}
                enableMultipleSelection={false}
                enableRowHeader={false}>

                <Column name="Name" cellRenderer={this.renderColumnName} />
                <Column name="Initial State" cellRenderer={this.renderColumnInitialState} />
            </Table>
        </div>
    }

    componentDidMount() {
        cardTypeService.findAll()
            .then(res => {
                if (res.status === 200) {
                    this.setState({ list: res.data });
                }
            });
    }

    renderColumnName = (rowIndex: number) => {
        return <Cell>{`${this.state.list[rowIndex].name}`}</Cell>;
    }

    renderColumnInitialState = (rowIndex: number) => {
        return <Cell>{`${this.state.list[rowIndex].initialState.name}`}</Cell>;
    }
}
