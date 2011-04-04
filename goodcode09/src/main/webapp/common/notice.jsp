<c:if test="${f:containsKey(flash, 'notice')}">
<div id="notice" class="notice">${f:out(flash['notice'])}</div>
</c:if>
