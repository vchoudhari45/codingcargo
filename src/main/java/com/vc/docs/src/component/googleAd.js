import React, { useEffect } from "react";

const GoogleAd = () => {
  useEffect(() => {
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }, []);

  return (
		<ins class="adsbygoogle ad_responsive"
			style={{display : "inline-block"}}
			data-ad-client="ca-pub-5837843548871883"
			data-ad-slot="1064283352"></ins>
  );
};

export default GoogleAd;