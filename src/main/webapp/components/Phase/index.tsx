import { Button, H1 } from "@blueprintjs/core";
import "@blueprintjs/core/lib/css/blueprint.css";
import "@blueprintjs/table/lib/css/table.css";
import React from "react";
import PhaseModel from "../../entities/phase/model";
import phaseService from "../../entities/phase/service";
import IPhaseIndexProps from "../typing/IPhaseIndexProps";
import IPhaseIndexState from "../typing/IPhaseIndexState";

export default class PhaseIndex extends React.Component<IPhaseIndexProps, IPhaseIndexState> {

    state = {
        list: [] as PhaseModel[]
    }

    renderLine = (element: PhaseModel) => {
        return (
            <div>
                <Button className="bp3-minimal" text={element.name} />
            </div>
        );
    }

    render() {
        return <div>
            <H1>Phases</H1>
            {this.state.list.map(this.renderLine)}
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
}
