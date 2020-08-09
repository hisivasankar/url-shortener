import * as React from "react";

interface Props {
    children: Object
}

export const Layout = (props: Props) => {
    return <div>
        {props.children}
    </div>
}