<h1>Job-application-api</h1>
<h2>Entites:</h2>
1) Applicant<br>
2) Company<br>
3) Job<br>
  <h3>Relation among entites:</h3>
   1) applicant apply for multiple job and for one job multiple applicant can apply it implies that it consider as many to many mapping
      (Required saperate table for it.)<br>
   2) One company can post multiple job offer (one to many)
      (In Job added one column fo company id)<br>
<br><br>
<h2>Attributes:</h2>
1) Applicant:
     id<br>
     Name<br>
     Age<br>
     Address<br>
     Email<br>
     Password<br>
     Skills(coma seprated skills e.g., "java,c++,php")<br>
     Expereince(May be included or may not)<br>
<br>
2) Job
     id<br>
     Title<br>
     salary<br>
     Loation<br>
     .<br>
     .<br>
     .<br>
     Company_id<br>
<br>
3) Company
     id<br>
     name<br>
     location<br>
     .<br>
     .<br>
     .<br>
<br>

<h2>Use Cases:</h2>
<br>All the user has its email(as username),password<br>
1) Applicant
      <ul>
      <li>can create its account</li>
     <li>Applicant see job by its company,title</li>
     <li>Applicant can see all job applied by him/her</li>
     <li>Applicant can see his/her own detail</li>
     <li>Applicant can update any of  the below thing:<br>
         => Skills<br>
         => Email<br>
      </li>
      </ul>
2) Company
     <ul>
     <li>Can see who are the intrested applicants</li>
     <li>Can see all the job posted by them</li>
     <li>Can modify job detail among these:<br>
       =>Salary<br>
       =>Location
     </li>
     <li>Can delete job posted by them</li>
     </ul>


     
