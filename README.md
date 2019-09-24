Firebase Push Notification Tutorial

<h2 style="text-align: left;"><span style="color: #000000;"><strong>How Firebase Push Notification works?</strong></span></h2>
<p><span style="color: #000000;">Firebase serves as a module between your server and the devices that will be receiving the push notifications that you create. Your server informs Firebase that a notification has to be sent. Then Firebase does the work behind the scenes to get the notification published.</span></p>
<p>&nbsp;</p>

<img src="images/img_7.png" alt="Image 1"/>

<h2 style="text-align: left;"><span style="color: #000000;"><strong>How to integrate FCM into Android Project?</strong></span></h2>
<p><span style="color: #000000;">Step for creating  Firebase Project</span></p>

<p><span style="color: #000000;"><strong><em>Step 1:</em></strong> Open Firebase</span> <a href="https://console.firebase.google.com/u/2/?pli=1">console</a></p>

<img src="images/img_1.png" alt="Image 1"/>

<p><span style="color: #000000;"><em><strong>Step 2: </strong></em>Click on Add project and give name to your project and select country. If you have already created a project skip this step.</span></p>
 
<img src="images/img_2.png" alt="Image 1"/>

<p><span style="color: #000000;"><em><strong>Step 3: </strong></em>Then select “Add Firebase to your Android app”.</span></p>
 
<img src="images/img_3.png" alt="Image 1"/>

<p><span style="color: #000000;"><em><strong>Step 4: </strong></em>Add project package id or application id and genrate SHA-1 signatature of your machine.</span></p>
 
<img src="images/img_4.png" alt="Image 1"/>

<p><span style="color: #000000;"><em><strong>Step 5: </strong></em>Download google-service.json and put into app module.</span></p>
 
<img src="images/img_5.png" alt="Image 1"/>

<h2><span style="color: #000000;"><strong>How to generate SHA Key using Android Studio:</strong></span></h2>
<ol>
<li><span style="color: #000000;">Open your project into Android studio.</span></li>
<li><span style="color: #000000;">Click on Gradle tab on right side.</span></li>
<li><span style="color: #000000;">Collapse :app module -&gt; Tasks -&gt; Android -&gt; signing report.</span></li>
<li><span style="color: #000000;">SHA-1 will generate. Copy and paste into SHA-1 in firebase console.</span></li>
</ol>

<img src="images/img_6.png" alt="Image 1"/>


<h2><span style="color: #000000;"><strong>How to integrate Firebase SDK into Android Project?</strong></span></h2>
<p><em><strong><span style="color: #000000;">Step 1:</span></strong></em></p>
<p><span style="color: #000000;">Add below code into &lt;project&gt;/build.gradle file.</span></p>
<pre class="line-numbers" data-start="1"><code class="language-markup">buildscript {
  dependencies {
    // Add this line
    classpath 'com.google.gms:google-services:4.3.2'
  }
}</code></pre>

<p><span style="color: #000000;"><em><strong>Step 2:</strong></em></span></p>
<p><span style="color: #000000;">Add below code into &lt;project&gt; / &lt;app&gt;/build.gradle.<br />
</span></p>
<pre class="line-numbers" data-start="1"><code class="language-kotlin">dependencies {
  // Add this line
  implementation 'com.google.firebase:firebase-messaging:20.0.0'
}
...
// Add to the bottom of the file
apply plugin: 'com.google.gms.google-services'</code></pre>

<p><em><strong><span style="color: #000000;">Step 3:</span></strong></em></p>
<p><span style="color: #000000;">Press on sync now in the Android Studio.</span></p>


<p><h2><span style="color: #000000;"><strong>Now you can send Push Notification using Firebase Console</strong></span></h2></p>

  1. Go to firebase console and select the app you created.
  2. From the left menu select notification.
  3. Click on new message.
  4. Enter message, select single device and paste the token you copied and click on send. The same as I did on the video, and check your device
  
So that's all for this Firebase Cloud Messaging Tutorial. If any query/suggestion for Firebase Cloud Messaging Tutorial ask freely on
hardikdungrani8@gmail.com

Thanks.
