import React, { useEffect } from "react";

const GoogleAd = () => {
  useEffect(() => {
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }, []);

  return (
		<ins class="adsbygoogle ad_responsive"
             data-ad-client="ca-pub-5837843548871883"
             data-ad-slot="1405717915"
             data-ad-format="horizontal"
             style="display:inline-block;min-width:150px;max-width:728px;width: 100%;height:90px"
             data-full-width-responsive="true"></ins>
  );
};

export default GoogleAd;