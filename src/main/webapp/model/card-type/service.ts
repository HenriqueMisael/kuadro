import CrudService from "../crud-service";
import CardTypeModel from "./model";

export default new CrudService<CardTypeModel>(`card-type`);