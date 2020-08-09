import * as React from "react";

interface Props {
  shortURL: string;
  originalURL: string;
}

const REDIRECTION_DELAY = 3000;

export const URL = (props: Props) => {
  const { shortURL, originalURL } = props;

  console.log(props);

  let redirectionAlert;
  if (!!originalURL) {
    redirectionAlert = (
      <p>
        Redirecting to <a href={originalURL}>{originalURL}</a> in 3 seconds...
      </p>
    );

    setTimeout(() => {
        window.location.href = originalURL;
    }, REDIRECTION_DELAY);
  }

  let shortURLContent;
  if (shortURL) {
    shortURLContent = `${shortURL} will be loaded`;
  } else {
    shortURLContent = "Invalid URL";
  }

  return (
    <div>
      <p>{shortURLContent} </p>
      {redirectionAlert}
    </div>
  );
};
