import * as React from "react";
import "./Advert.scss";

interface Props {
    text: String;
    description: String;
}

export const Advert = (props: Props) => {
    return <div className="ad">
        <h3>{props.text}</h3>
        <p>{props.description}</p>
    </div>
}