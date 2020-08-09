export const getShortURL = () => {
    const url = window.location.pathname;
    const match = url && url.match(/\/r\/(.*)/);

    if (match && match[1]) {
        return match[1];
    }

    return "Invalid URL";
}