import { jwtVerify } from "jose";

export const getDataFromToken = async (request) => {
    try {
        const secret = new TextEncoder().encode(process.env.TOKEN_SECRET);
        const token = request.cookies.get("token")?.value || "";
        const decodedToken = await jwtVerify(token, secret, {
            issuer: "urn:blogPost:issuer",
            audience: "urn:user:audience",
        });
        return decodedToken.payload.id;
    } catch (error) {
        console.log(error)
        throw new Error(error.message);
    }
};
