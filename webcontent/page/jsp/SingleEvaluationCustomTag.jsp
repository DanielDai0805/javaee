<%@ taglib uri="/WEB-INF/customTag.tld" prefix="ct"%>
<html>
  <head>
    <style>
    </style>
    <title>Custom tag</title>
  </head>
  <body>
    <h2 align="center"><ct:changeCase caseFlag="upper">hello World</ct:changeCase></h2>
    <h2 align="center"><ct:changeCase caseFlag="lower">hello World</ct:changeCase></h2>
  </body>
</html>
