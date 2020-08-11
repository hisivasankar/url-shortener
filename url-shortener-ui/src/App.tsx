import * as React from "react";

import { Layout } from "./components/Layout";
import { Advert } from "./components/Advert";
import { URL } from "./components/URL";

import * as Interfaces from "./interfaces/Interfaces";
import * as Utils from "./utils/Utils";

interface Props {}

interface State {
  advert: Interfaces.Advert;
  urlInfo: Interfaces.URL;
}

const SERVER_URL_PLACEHOLDER = "/api/url";

class App extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);
    this.state = {
      advert: {
        text: "Sample Advert",
        description: "Advertise here!",
      },
      urlInfo: {
        originalURL: "",
        shortURL: "",
      },
    };
  }

  componentDidMount() {
    const shortURL = Utils.getShortURL();
    const serverURL = `${SERVER_URL_PLACEHOLDER}/${shortURL}`;
    fetch(serverURL, {
      headers: {
        accept: "application/json",
      },
    })
      .then((response) => {
        if (response.status == 200) {
          return response.json();
        }
        return {};
      })
      .then((data: any) => {
        const { advert, url } = data;
        if (advert) {
          this.setState({
            advert: advert,
          });
        }

        if (url) {
          this.setState({
            urlInfo: url,
          });
        }
      })
      .catch((err) => {
        console.error(err);
      });
  }

  render() {
    return (
      <Layout>
        <Advert {...this.state.advert} />
        <URL {...this.state.urlInfo} />
      </Layout>
    );
  }
}

export default App;
