# AI-use log

## Log Table

<table>
  <thead>
    <tr>
      <th style="width: 11%;">Date</th>
      <th style="width: 22%;">What you were trying to do</th>
      <th style="width: 22%;">What you prompted (short)</th>
      <th style="width: 22%;">What the model produced</th>
      <th style="width: 23%;">What you accepted or rejected, and WHY</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>31-10-2026</b></td>
      <td>Generate 2-screen clickable prototype (Schedule & Scanner views)</td>
      <td>"Create a 2-screen Jetpack Compose prototype with Material 3 for MedLabel: Screen 1 shows a list of scheduled medications with a FAB, Screen 2 shows a scanner view with input fields, linked with Navigation Compose."</td>
      <td>Complete 2-screen prototype structure including <code>NavHost</code>, <code>ScheduleScreen</code>, <code>ScannerScreen</code>, and Material 3 cards.</td>
      <td><b>ACCEPTED:</b> Overall layout and screen navigation.<br><br><b>MODIFIED:</b> Tweaked card padding, changed the FAB button label to "Scan Label", and adjusted text field alignment.<br><br><b>REJECTED:</b> Hardcoded background colors; switched them to use default Material3 surface colors.</td>
    </tr>
    <tr>
      <td><b>31-10-2026</b></td>
      <td>Create mock medication data model and sample list</td>
      <td>"Create a Kotlin data class MedicationEntry and a hardcoded list of sample medications for the schedule view."</td>
      <td><code>MedicationEntry</code> data class and a hardcoded list with sample items.</td>
      <td><b>ACCEPTED:</b> Basic structure (name, dosage, instructions).<br><br><b>MODIFIED:</b> Renamed fields to match simple names (e.g., <code>dosage</code> instead of <code>dosageString</code>) and updated mock items to realistic medicine names like Lisinopril and Metformin.</td>
    </tr>
    <tr>
      <td><b>31-10-2026</b></td>
      <td>Fix initial Gradle setup and missing resource errors</td>
      <td>"Fix Gradle setup errors and missing manifest icon references so the app can compile and run."</td>
      <td>Updated <code>build.gradle.kts</code> configuration, aligned Compose compiler plugin, and cleaned <code>AndroidManifest.xml</code>.</td>
      <td><b>ACCEPTED:</b> Updated <code>compileSdk</code> to 35 and set default system icon (<code>@android:drawable/sym_def_app_icon</code>) so the prototype builds and launches cleanly on the emulator.</td>
    </tr>
  </tbody>
</table>
