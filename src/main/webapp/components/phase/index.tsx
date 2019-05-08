import { H1 } from "@blueprintjs/core";
import "@blueprintjs/core/lib/css/blueprint.css";
import { Cell, Column, Table } from "@blueprintjs/table";
import "@blueprintjs/table/lib/css/table.css";
import React from "react";
import PhaseModel from "../../model/phase/model";
import phaseService from "../../model/phase/service";

export default class PhaseIndex extends React.Component {

    state = {
        list: [] as PhaseModel[]
    }

    render() {
        return <div>
            <H1>Phases</H1>
            <Table numRows={this.state.list.length}
                enableMultipleSelection={false}
                enableRowHeader={false}>

                <Column name="Name" cellRenderer={this.renderColumnName} />
            </Table>
        </div>
    }

    componentDidMount() {
        phaseService.findAll()
            .then(res => {
                if (res.status === 200) {
                    this.setState({ list: res.data });
                }
            });
    }

    renderColumnName = (rowIndex: number) => {
        return <Cell>{`${this.state.list[rowIndex].name}`}</Cell>;
    }
}
