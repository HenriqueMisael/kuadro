import {Component, ReactNode} from "react";

export default interface IListDetailProps<MODEL> {
    title: string,
    list: MODEL[]
}