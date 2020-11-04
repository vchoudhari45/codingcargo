import React, { useEffect } from "react";

const GoogleAd = () => {
  useEffect(() => {
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }, []);

  return (
		<ins class="adsbygoogle ad_slot"
			 data-ad-client="ca-pub-5837843548871883"
             data-ad-slot="1405717915"></ins>
  );
};

export default GoogleAd;