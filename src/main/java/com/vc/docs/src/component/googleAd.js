import React, { useEffect } from "react";

const GoogleAd = () => {
  useEffect(() => {
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }, []);

  return (
		<ins class="adsbygoogle"
			style={{display : "block"}}
			data-ad-client="ca-pub-5837843548871883"
			data-ad-slot="1064283352"
			data-ad-format="auto"
			data-full-width-responsive="true"></ins>
  );
};

export default GoogleAd;