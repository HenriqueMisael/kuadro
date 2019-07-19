import "@blueprintjs/core/lib/css/blueprint.css";
import "@blueprintjs/table/lib/css/table.css";
import React from "react";
import PhaseModel from "../../entities/phase/model";
import IPhaseIndexProps from "./IPhaseIndexProps";
import IPhaseIndexState from "./IPhaseIndexState";
import ListDetail from "../ListDetail";

export default class PhaseIndex extends React.Component<IPhaseIndexProps, IPhaseIndexState> {

    state = {
        list: [] as PhaseModel[]
    };

    componentDidMount() {
        // phaseService.findAll()
        //     .then(res => {
        //         if (res.status === 200) {
        //             this.setState({list: res.data});
        //         }
        //     });
        const list: PhaseModel[] = [
            {
                id: 1,
                name: 'On Budget'
            },
            {
                id: 2,
                name: 'Development'
            }
        ];
        this.setState({list});
    }

    render() {
        return (
            <ListDetail title='Phase' list={this.state.list}/>
        )
    }
}
