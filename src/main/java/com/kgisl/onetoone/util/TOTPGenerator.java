// package com.kgisl.onetoone.util;
// import java.security.SecureRandom;

// import dev.samstevens.totp.code.DefaultCodeGenerator;
// import dev.samstevens.totp.time.TimeProvider;

// public class TOTPGenerator {
//     public static String generateBase32SecretKey(int length) {
//         SecureRandom random = new SecureRandom();
//         byte[] bytes = new byte[length];
//         random.nextBytes(bytes); 

//         // Encode the byte array into Base32
//         String secretKey = BaseEncoding.base32().encode(bytes);
//         return secretKey;
//     }

//     public static String generateTOTP(String secret) {
//         // Use the time provider to get the current time
//         TimeProvider timeProvider = new TimeProvider();

//         // Code generator using SHA-1 algorithm (can use SHA-256, SHA-512)
//         DefaultCodeGenerator codeGenerator = new DefaultCodeGenerator();

//         // Generate TOTP based on the secret and current time
//         long currentTimeSeconds = timeProvider.getTime();
//         String otp = codeGenerator.generate(secret, currentTimeSeconds);
//         return otp;
//     }

// }
