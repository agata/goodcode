<c:if test="${!empty errors.all}">
  <div id="errors" class="errors">
    <ul>
    <c:forEach var="error" varStatus="s" items="${errors.all}">
      <li>${fn:replace(error, "
", "<br/>")}</li>
    </c:forEach>
    </ul>
  </div>
</c:if>
