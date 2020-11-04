import React, { useEffect } from "react";

const GoogleAd = () => {
  useEffect(() => {
    (window.adsbygoogle = window.adsbygoogle || []).push({});
  }, []);

  return (
		<ins class="adsbygoogle"
				 styles="display:block;min-width:100px;max-width:728px;width:100%;height:90px"
		     data-ad-client="ca-pub-5837843548871883"
         data-ad-slot="1405717915"></ins>
  );
};

export default GoogleAd;