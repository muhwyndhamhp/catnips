# CatNips

Simple app to show cat images as requested by Alodokter recruitment team to apply for their Android Developer position. 

Consideration and asumption I use to complete this task :
- No user security is needed (password hashing, salting, encrypting)
- Not using internet for basic functionalities (All local based, Internet will be used to load url-based Images)
- Cat's data is pre-populated
- User don't have access to write new Cat data
- User data is assumed (no input for several key user's information such as name, profile image, and phone number)
- This app will be expanded upon in the future (such things where I use quite robust app architecture to avoid mess if future implementation is needed)
- User *WILL BE ABLE* to write new Cat data with minimum modification to the code
- And many more...

With that said, there are several key improvement that could be done in the future if requested, such as :
- Proper user Registration section 
- User data security for sensitive informations (Password, Email, Phone Number, Name, etc)
- Backend-sourced data
- More elaborate Cat's data
- Better Interface
- Loading state (currently with the asumption that the data is prepopulated and small enough, there is no merit in having loading state)
- Error state handling

To complete this task, I use several notable libraries such as :
- MVVM
- ViewBinding
- DataBinding
- Hilt (Dagger2 Lite)
- Room Database
- Jetpack Navigation
- Glide
- AndroidX
- Material

