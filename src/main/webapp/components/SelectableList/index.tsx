import {Button} from "@blueprintjs/core/lib/esm/components/button/buttons";
import React from "react";

interface SelectableListProps<MODEL> {
    list: MODEL[],
    selected: MODEL[],
    onSelectItem?: (model: MODEL) => void,
    singleSelection?: boolean
}

export default <MODEL extends any> ({list, selected, onSelectItem = () => {}, singleSelection = true}: SelectableListProps<MODEL>) => (
    <ul>
        {list.map(item => <Button active={selected.includes(item)} onClick={() => onSelectItem(item)} />)}
    </ul>
);