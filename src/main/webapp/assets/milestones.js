// Demo UI; production must add CSRF protection, authorization and escaping.
$(function(){ $.getJSON('api/engagements/10/milestones',function(items){const body=$('#rows').empty();items.forEach(function(m){const tr=$('<tr>');[m.id,m.title,m.owner,m.dueDate,m.status].forEach(x=>tr.append($('<td>').text(x)));body.append(tr);});});});
